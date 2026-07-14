package business;

public class Menu {

    MenuItem[] menuItems = new MenuItem[20];

    int current = 0;

    Menu(){

        menuItems[current++] = new MenuItem("Burger",12.5);

        menuItems[current++] = new MenuItem("Pizza",18);

        menuItems[current++] = new MenuItem("Pasta",15);

    }


    //method to convert string to menuitem
    public MenuItem searchItem(String name){
        for(int i = 0; i < current; i++){
            if(menuItems[i].name.equalsIgnoreCase(name)){
                return menuItems[i];
            }
        }
        return null;
    }


    public void display(){
        System.out.println("===========Menu==========");
        for(int i = 0; i < current; i++){
            System.out.printf("%d. %-10s $%.2f\n",
                    i + 1,
                    menuItems[i].name,
                    menuItems[i].price);
        }
    }
}


