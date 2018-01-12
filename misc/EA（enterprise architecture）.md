## 常用图示：  

*Source*[[1]](http://www.sparxsystems.com/enterprise_architect_user_guide/12.1/index/index.html)

### Fragment:(表示这段流程是一个整体，是否可选或者其他)  
  
* Definition: A Combined Fragment reflects ***a piece or pieces of interaction*** (called interaction operands) ***controlled by an interaction*** operator, whose corresponding boolean conditions are known as interaction constraints. It displays as a transparent window, divided by horizontal lines for each operand.
  
![fragment](http://www.sparxsystems.com/enterprise_architect_user_guide/10/images/d_fragment.png)  
* Usage:   
![fragment](http://www.sparxsystems.com/enterprise_architect_user_guide/10/images/sdinteractionfragment.png)  

* Archetecture:   
![fragment](http://www.sparxsystems.com/enterprise_architect_user_guide/10/images/combinedfragmentconditionorder1.png)

### Association: (类之间的关联关系)  
* 默认双向，选中右击，***property，Direction(source->target)改为单向***，则有箭头。其中还可以添加roles来确定通过什么来关联  
![association](http://www.sparxsystems.com/enterprise_architect_user_guide/12.1/images/d_associationclass.png)

### Short cut key
1 . F9 or F10 !!! add attributes and operations shortcut  
2 . ctrl + right click !!! add relations inlcude dependency and association and realization and inheritance and composite and aggregate
