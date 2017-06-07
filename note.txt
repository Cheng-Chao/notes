design patterns
---------------------------------
observer 
---------------------------------
intent
Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
---------------------------------  
objects  
Subject; Observer; ConcreteObserver; ConcreteSubject;

  Subject //abstract class
  elementary: none;
  function:detach(obverser);attatch(observer);notify(){for each observers: {observer.update()} };
  
  Observer //interface
  elementary: none
  function:update();
  
  ConcreteObserver:public subject //instance
  elementary:status
  function: 
  implement Observer::update(){status = ConcreteSubject.GetState() };
  
  ConcreteSubject:public subject //instance
  elementary: status
  function:
  GetStatus(){return this.status};
  SetStatus(){this.status = 0xFFFFFFFF};
---------------------------------  
 
 
 
 
