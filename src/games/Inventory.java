package games;

public class Inventory {

    Item[] items;
    int maxCapacity;
    double maxWeight;

    int currentCapacity;
    double currentWeight;



    //constructor
    Inventory(){
        this.maxCapacity = 20;
        this.maxWeight = 50;
        this.items = new Item[maxCapacity];

        this.currentCapacity = 0;
        this.currentWeight = 0;
    }


    boolean isFull(){
        return (this.currentCapacity >= this.maxCapacity);
    }


    //check inventory
    void checkInventory(){
        for(int i = 0; i < this.currentCapacity; i++)
        {
            System.out.print(this.items[i].name + " ");
        }
        System.out.println();
    }


    //add item
    boolean addItem(Item newItem) {
        if (isFull()) {
            System.out.println("Inventory is full");
            return false;
        }
        this.items[this.currentCapacity] = newItem;
        this.currentCapacity++;
        return true;
    }


    //remove item
    void removeItem(Item itemToRemove){
        int index = findIndexOfItem(itemToRemove);
        if(index != -1){

            //shift items to the left
            for(int i = index; i < currentCapacity - 1; i++){
                this.items[i] = this.items[i + 1];
            }
            this.items[this.currentCapacity - 1] = null;
            this.currentCapacity -= 1;
        }
        else{
            System.out.println("Item not existed");
        }
    }


    int findIndexOfItem(Item itemToFind) {
        for (int i = 0; i < this.currentCapacity; i++) {
            if (itemToFind == this.items[i]) {
                return i;
            }
        }
        return -1;
    }


}




