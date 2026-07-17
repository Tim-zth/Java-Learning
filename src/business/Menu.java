package business;

import java.util.ArrayList;

public class Menu {

    private final ArrayList<MenuItem> menuItems = new ArrayList<>();

    public Menu(){

        menuItems.add(new MenuItem("Burger",12.5));
        menuItems.add(new MenuItem("Pizza",18));
        menuItems.add(new MenuItem("Pasta",15));
    }


    //method to convert string to menuitem
    public MenuItem searchItem(String name){
        for (MenuItem menuItem : menuItems) {
            if (menuItem.getName().equalsIgnoreCase(name)) {
                return menuItem;
            }
        }
        return null;
    }


    public void display(){
        System.out.println("===========Menu==========");
        for(int i = 0; i < menuItems.size(); i++){
            System.out.printf("%d. %-10s $%.2f\n",
                    i + 1,
                    menuItems.get(i).getName(),
                    menuItems.get(i).getPrice());
        }
    }
}


