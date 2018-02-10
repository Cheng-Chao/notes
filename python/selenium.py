# coding=utf-8
# python3.5.2
# uWIN云龙自动化爬虫工具
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import os
import logging
import time
import re
import xlrd
import xlsxwriter
import threading


class readexcel:
    def __init__(self, exceldemo):
        try:
            readbook = xlrd.open_workbook(exceldemo)
            # 获取本次流水线名称及检查指标项目
            CheckItems = readbook.sheet_by_name('CheckItems')
            self.pipelinegroup = CheckItems.col_values(0)[1:]
            self.Targets = CheckItems.row_values(0)[1:]
            # 获取excel中存储的用户名密码
            loginevidence = readbook.sheet_by_name('Evidence')
            self.username = loginevidence.cell(0, 1).value
            self.password = loginevidence.cell(1, 1).value
            self.distribute()
        except Exception as readerror:
            logging.error('Get Basic Information error: \n%s' % readerror)

    def distribute(self):
        try:
            # 按照多线程数，将流水线名称进行等分拆分
            for line in range(semnum):
                pipelines = self.pipelinegroup[line::semnum]
                td=threading.Thread(target=collection, args=(self.username, self.password,pipelines,self.Targets))
                td.start()
                time.sleep(0.5)
            while threading.active_count() != 1:
                pass
            else:
                logging.info('流水线数据搜集完毕, 启动清洗分析')
                logging.info(TotallyResult)
                writeexcel(self.Targets)
        except Exception as distributeerror:
            logging.error('distribute pipeline error: \n%s' % distributeerror)


class writeexcel:
    def __init__(self, Targets):
        self.Title = Targets
        self.createexcel()

    def createexcel(self):
        try:
            workbook = xlsxwriter.Workbook('BuildResult%s.xlsx' % localtime)  # 创建工作簿
            sheetname = workbook.add_worksheet('BuildResult')  # 创建sheet
            #抬头样式
            titlestyle=workbook.add_format({'border': 1,'bold': True, 'align': 'center','font_name': '宋体','font_size':14,'bg_color':'yellow','color':'red'})
            indexstyle=workbook.add_format({'border': 1,'align': 'center','font_name': '宋体','font_size':11,'bg_color':'green'})
            # 添加指标title
            sheetname.set_column(0, 0, 20)
            sheetname.write(0, 0,'Summarize',titlestyle)
            for i in range(0, len(self.Title)):
                sheetname.set_column( i+1, i+1,len(self.Title[i])+2)
                sheetname.write(0, i+1, self.Title[i],titlestyle)
            rownumber = 1
            for linename, itemresults in TotallyResult.items():
                sheetname.write(rownumber, 0, linename,indexstyle)
                try:
                    for columnnumber in range(len(self.Title)):
                        sheetname.write(rownumber, columnnumber + 1, itemresults[self.Title[columnnumber]],indexstyle)
                except Exception as writedetailerror :
                        logging.error(writedetailerror)
                rownumber += 1
            workbook.close()
            logging.info("云龙爬虫工具执行完成....")
        except Exception as writeexcelerror:
            logging.error('write results into excel get error : \n%s' % writeexcelerror)


class collection:
    def __init__(self, username, password, pipelines, Targets):
        try:
            sem.acquire()
            self.url = url
            self.username = username
            self.password = password
            self.Targets = Targets
            self.pipelines=pipelines
            for pipeline in self.pipelines:
                self.login(pipeline)
        except Exception as initerror:
            logging.error(initerror)

    def login(self,pipeline):
        try:
            self.driver = webdriver.Chrome()
            # self.driver.maximize_window()  # 浏览器最大化
            self.driver.set_window_size(800, 600)
            self.driver.get(self.url)
            self.driver.implicitly_wait(10)
            # 判断是否w3跳转，并输入用户名密码
            if self.driver.current_url != url:
                self.driver.find_element_by_id('uid').send_keys(self.username)
                self.driver.find_element_by_id('password').send_keys(self.password)
                self.driver.find_element_by_name('Submit').click()
            # 填写所需爬取的流水线名称
            time.sleep(1)
            self.driver.find_element_by_name('searchPipe').send_keys(pipeline)
            time.sleep(1)
            # 点击搜索按钮
            self.driver.find_element_by_id('searchPipelineID').click()
            time.sleep(2)
            # 点击流水线结果，进入该流水线
            self.driver.find_element_by_id('goDetailIDTable_%s' % pipeline).click()
            # 点击质量下拉条按钮
            time.sleep(2)
            self.driver.find_element_by_id('detailqualityDetailsID_build').click()
            self.indexcollect(pipeline)
        except Exception as searcherror:
            logging.error('search pipeline error: \n%s' % searcherror)
            sem.release()

    def indexcollect(self,pipeline):
        try:
            # 搜集该流水线整体结果
            self.summarise = {}
            # 找到统计指标的所有总结点
            TotalResult = self.driver.find_elements_by_class_name('build-check')
            for ResultType in TotalResult:
                # 获取指标分类
                CheckStyle = ResultType.find_element_by_tag_name('span').text
                if CheckStyle in self.Targets:
                    SumItem = 0
                    # 统计指标名称与数据
                    for Item in ResultType.find_elements_by_class_name('check-item'):
                        ItemValue = re.sub('\s', '', Item.text).replace('::', ':').split(':')[-1]
                        # 合并指标分类与名称对应的数据
                        SumItem += int(ItemValue)
                    self.summarise[CheckStyle] = SumItem
                else:
                    for Item in ResultType.find_elements_by_class_name('check-item'):
                        ItemKey, ItemValue = re.sub('\s', '', Item.text).replace('::', ':').split(':')
                        if ItemKey in self.Targets:
                            self.summarise[ItemKey] = ItemValue
            # 获取当前窗口名称
            nowhandle = self.driver.current_window_handle
            # 点击进入uadpguarding详细界面
            self.driver.find_element_by_id('windowOpenUrlID_job_Build_uadpguarding').click()
            time.sleep(0.5)
            # 获取当前窗体名称list
            allhandle = self.driver.window_handles
            for handle in allhandle:
                if handle != nowhandle:
                    # 切换至新窗口
                    self.driver.switch_to.window(handle)
                    search_CodeNum = (By.ID, 'buildDetail-htmlnew-119')
                    WebDriverWait(self.driver, 15).until(EC.visibility_of_element_located(search_CodeNum))
                    # 获取codenum数值并存储
                    self.summarise['codenum'] = self.driver.find_element_by_id('buildDetail-htmlnew-119').text
            self.driver.quit()
            logging.info('%s 流水线数据统计结果如下：\n %s' % (pipeline, self.summarise))  # 打印已保存的dict
            # 将此流水线的参数结果集插入总表
            TotallyResult[pipeline] = self.summarise
            sem.release()
        except Exception as indexcollect:
            logging.error('indexcollect get error: \n%s' % indexcollect)
            sem.release()

if __name__ == '__main__':
    # 定义时间格式
    localtime = time.strftime("%Y%m%d%H%M%S", time.localtime())

    # 获取目录信息
    local_dir = os.path.dirname(os.path.realpath(__file__))
    logpath = os.path.join(local_dir, 'CloudDragonLog')
    if not os.path.exists(logpath):
        os.mkdir(logpath)

    # 日志模块
    logging.basicConfig(filename='%s/%s.log' % (logpath, localtime),
                        level=logging.INFO, format=('%(asctime)s: %(message)s'),
                        datefmt="%y-%m-%d %H:%M:%S")

    # 前台console
    console = logging.StreamHandler()
    console.setLevel(logging.INFO)
    formatter = logging.Formatter('%(asctime)s: %(message)s', "%y-%m-%d %H:%M:%S")
    console.setFormatter(formatter)
    logging.getLogger().addHandler(console)
        
    #这个就屏蔽下吧...
    url = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    # 设置chromedriver同时执行数
    semnum=4
    sem = threading.Semaphore(semnum)
    # 汇总流水线参数总表
    TotallyResult = {}
    exceldemo = 'BasicInformation.xlsx'
    logging.info("启动云龙数据爬虫工具...")
    readexcel(exceldemo)
