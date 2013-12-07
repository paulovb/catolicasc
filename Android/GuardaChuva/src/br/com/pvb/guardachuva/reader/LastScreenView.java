package br.com.pvb.guardachuva.reader;

public class LastScreenView {
	
	public enum Screen{
        
        Registry(1,"Salvar"),
        Rent(2,"Emprestar"),
        Return(3,"Devolver");

        private int screen;
        private String namebutton;
        
        Screen(int screen, String namebutton){
        	this.screen = screen;
        	this.namebutton = namebutton;
        }

        public int getScreen(){
            return this.screen;
        }
        
        public String getNameButton(){
            return this.namebutton;
        }
    }

}
