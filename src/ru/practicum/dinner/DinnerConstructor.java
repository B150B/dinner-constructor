package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> menu;
    Random random;

    DinnerConstructor() {
        menu = new HashMap<>();
        random = new Random();
    }

    void addNewDishToMenu(String dishtype, String dishname) {
        if (checkType(dishtype)) {
            if (!menu.get(dishtype).contains(dishname)) {
                menu.get(dishtype).add(dishname);
            } else {
                System.out.println("Такое блюдо уже есть! Блюдо не добавлено");
            }
        } else {
            ArrayList<String> arrayListForNewCategory = new ArrayList<>();
            arrayListForNewCategory.add(dishname);
            menu.put(dishtype, arrayListForNewCategory);
        }
    }



    boolean checkType(String type) {
        return menu.containsKey(type);
    }

    void generateDishCombo(int numbersOfCombos, ArrayList<String> dishCategory) {
        ArrayList<String> combo = new ArrayList<>();
        for (int i = 0; i < numbersOfCombos; i++) {
            System.out.println("Комбо " + (i + 1));
            for (String dish : dishCategory) {
                combo.add(menu.get(dish).get(random.nextInt(menu.get(dish).size())));
            }
            printCombo(combo);
            combo.clear();
        }

    }

    void printCombo(ArrayList<String> combo) {
        System.out.print("[");
        for (int i = 0; i < combo.size(); i++) {
            if (i != combo.size() - 1) {
                System.out.print(combo.get(i) + ", ");
            } else {
                System.out.println(combo.get(i) + "]");
            }
        }
    }


}
