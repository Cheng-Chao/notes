catch .h



#define ERROR_CODE() __catch_error_code
#define ERROR_LINE_NO() __catch_error_line_no
#define ERROR_PROC() __catch_error_line_no = __LINE__;

#define PROC GO_UINT32 __catch_error_code = 0x7FFFFFCC; GO_UINT32 __catch_error_line_no = 0xFFFFFFFF; {
#define END_PROC /*lint -e827 -save*/GO_ASSERT_FALSE();/*lint -restore*/} \
__tabErrorCode:
#define THROW(errcode) {__catch_error_code = (errcode); ERROR_PROC(); /*lint -e(801) goto*/goto __tabErrorCode;}/*lint -e(527) ;Unreachable*/
#define EXEC(func) {if(GO_SUCCESS != (__catch_error_code = (func))) THROW (__catch_error_code)}
#define ASSERT_EXEC(func) {if(GO_SUCCESS != (__catch_error_code = (func))){GO_ASSERT_FALSE(); THROW (__catch_error_code)}}
#define NEW_ERROR_EXEC(errcode, func) {if(GO_SUCCESS != (func)){THROW(errcode)}}
#define JUDGE(errcode, expr) {if(!(expr) ){THROW(errcode)}}
#define ASSERT_JUDGE(errcode, expr) {if(!(expr) ){GO_ASSERT_FALSE();THROW(errcode)}}
// #define JUDGE_FALSE(errcode, expr) {if(expr){THROW(errcode)}}
#define CATCH_ERROR(errcode) if(__catch_error_code == (errcode)){//ERROR_LOG();

#define GOF_CATCH_ALL_ERROR {GO_Trace(GO_TRACE_TYPE_ERR, __FILE__, FUNCTION_NAME, __catch_error_line_no, "ErrorCode = 0x%x", __catch_error_code); GOF_CatchLog(__FILE__, __catch_error_line_no, __catch_error_code);

#define END_CATCH_ERROR }/*lint -esym(550, __catch_error_line_no) Symbol '__catch_error_line_no' not accessed*/
#define FINAL __tabFinal:
#define END_FINAL GO_ASSERT_FALSE();
#define GOTO_FINAL() goto __tabFinal;
#define EXEC_SEND_MSG(func, ptr) {if(GO_SUCCESS != (__catch_error_code = (func))){ptr = NULL; THROW (__catch_error_code)}ptr = NULL;}

