/*------------------use macros to define a Singleton----------------*/    	
#define DECLEAR_GET_INSTANCE(class_name)
public:                             \
static class_name* GetInstance()    \
{                                  \
  static class_name* instance = NULL;\
  if(NULL == instance)             \
  {                                \
    instance = new class_name;     \
  }                                \
  return instance;                 \
}                                   

#define DECLARE_SINGLETON(class_name)  
DECLEAR_GET_INSTANCE(class_name)   \
protected:                         \
class_name();                      \
~class_name();                     \
class_name(const class_name& );    \
const class_name& operator=(const class_name&);
    
//  using method;
class singleton{
DECLARE_SINGLETON(singleton)
}
       
