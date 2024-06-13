package org.anderson.curso_ada.stack;

public class Main {
    public static void main(String[] args) {
//        Stack myStack = new Stack(2);
//        myStack.push(1);
//
//        myStack.getHeight();
//        System.out.println("###########################");
//        myStack.getTop();
//        myStack.print();
//        System.out.println("###########################");
//
//        myStack.pop();
//
//        myStack.getHeight();
//        System.out.println("###########################");
//        myStack.getTop();
//        myStack.print();
//        System.out.println("###########################");
//
//        myStack.pop();
//
//        myStack.print();


        int[] nums = {5,4,3,2,1};
        Stack stack = new Stack(nums[0]);

        System.out.println("Start:");
        for(int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }

        for (int i = 1; i < nums.length; i++) {
            stack.push(nums[i]);
        }

        System.out.println("Inverted numbers: ");
        stack.print();
    }
}
