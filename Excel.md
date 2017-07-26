## 07.26  
#### 遇到的问题：  
    enCellType
    usPhyCellID
    usFreqBand
    enDlBd
    enUlBd
    ulDlEarfcn
    ulUlEarfcn
    ucSubframeAssign
    enDlCyclicPrefix
    enUlCyclicPrefix
    enTxAntNum
    enRxAntNum

根据头俩个字符转化为  

      VOS_UINT32(or 16 or 8) enCellType  
规则是：  

      us->UINT16; uc->UINT8; en->UINT32;  
#### 解决方法：  
Excel 编程解决:

    =IF(MID(I1,1,2)="en","VOS_INT32",IF(MID(I1,1,2)="us","VOS_UINT16",IF(MID(I1,1,2)="uc","VOS_UINT8","")))
      

