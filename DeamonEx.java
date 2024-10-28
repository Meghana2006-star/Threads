class DeamonEX{
public static void main(String []args)
  {
   ThreadEX  t1=new ThreadEX();
     System.out.println("Main thread name: "+this.getName());
     System.out.println("Priority: "+t1.getPriority());
   System.out.println("This is from main thread");
    t1.start(); System.out.println("Again from main");
  }
  }