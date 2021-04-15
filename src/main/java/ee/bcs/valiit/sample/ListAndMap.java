package ee.bcs.valiit.sample;

import java.util.*;

public class ListAndMap {

    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add(0,"tere");
        test.add(1,"hola");
        test.add(2,"Sõnum");
        test.add(3,"Kustutan ära so");
        test.set(0,"oh");
        test.remove(3);
        System.out.println(test);

        //HashSetis on ainult identsed väärtused;
        Set<Integer> uniqueNumbersSet = new HashSet<>();
        uniqueNumbersSet.add(0);
        uniqueNumbersSet.add(1);
        uniqueNumbersSet.add(2);
        uniqueNumbersSet.add(1);
        uniqueNumbersSet.remove(1);
        uniqueNumbersSet.add(7);
        for (int x : uniqueNumbersSet){
            System.out.println(x);
        }
        System.out.println(uniqueNumbersSet);

        //TreeSet sorteerib väärtused;
        Set<Integer> listiKatsetus = new TreeSet<>();
        listiKatsetus.add(3);
        listiKatsetus.add(2);
        listiKatsetus.add(1);
        listiKatsetus.add(7);
        listiKatsetus.add(5);
        System.out.println(listiKatsetus);

        Map<String,Integer> vanused = new HashMap<>();
        vanused.put("Mati",25);
        vanused.put("Marek",20);
        vanused.put("Aare",21);
        vanused.put("Martin",35);
        vanused.put("Märt",42);
        for (String nimi : vanused.keySet()){
            System.out.println(nimi + " is " + vanused.get(nimi) + "years old");
        }

        System.out.println(vanused.values());
        System.out.println(vanused.keySet());
        System.out.println(vanused.get("Mati"));

    }

}
