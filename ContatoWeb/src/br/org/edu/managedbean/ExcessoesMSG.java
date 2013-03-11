package br.org.edu.managedbean;

public class ExcessoesMSG extends Exception {

	private static final long serialVersionUID = -8513368531864116458L;

	public ExcessoesMSG(){
		
	}

    public ExcessoesMSG(String arg){
		super(arg);
	}
    
   public ExcessoesMSG(Throwable arg){
	   super(arg);
   }

   public ExcessoesMSG(String arg, Throwable arg1){
	   super(arg, arg1);
	}
}
