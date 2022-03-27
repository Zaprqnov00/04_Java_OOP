package T1_Abstraction.Exercices.GreedyTimes_06;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long capacityBag = Long.parseLong(scanner.nextLine());
        String[] items = scanner.nextLine().split("\\s+");

        var bag = new LinkedHashMap<String, LinkedHashMap<String, Long>>();
        long gold = 0;
        long stone = 0;
        long money = 0;

        for (int i = 0; i < items.length; i += 2) {
            String name = items[i];
            long count = Long.parseLong(items[i + 1]);

            String itemName = "";

            itemName = searchItem(name, itemName);

            if (itemName.equals("")) {
                continue;
            } else if (capacityBag < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + count) {
                continue;
            }

            switch (itemName) {
                case "Gem":
                    if (fillItems(bag, count, itemName, "Gold")) continue;
                    break;
                case "Cash":
                    if (fillItems(bag, count, itemName, "Gem")) continue;
                    break;
            }

            if (!bag.containsKey(itemName)) {
                bag.put((itemName), new LinkedHashMap<>());
            }

            if (!bag.get(itemName).containsKey(name)) {
                bag.get(itemName).put(name, 0L);
            }


            bag.get(itemName).put(name, bag.get(itemName).get(name) + count);

            if (itemName.equals("Gold")) {
                gold += count;
            } else if (itemName.equals("Gem")) {
                stone += count;
            } else if (itemName.equals("Cash")) {
                money += count;
            }
        }

        printResult(bag);
    }

    private static void printResult(LinkedHashMap<String, LinkedHashMap<String, Long>> bag) {
        for (var x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.printf("<%s> $%s%n", x.getKey(), sumValues);

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }

    private static boolean fillItems(LinkedHashMap<String, LinkedHashMap<String, Long>> bag, long count, String itemName, String gold2) {
        if (!bag.containsKey(itemName)) {
            if (bag.containsKey(gold2)) {
                if (count > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                    return true;
                }
            } else {
                return true;
            }
        } else if (bag.get(itemName).values().stream().mapToLong(e -> e).sum() + count > bag.get(gold2).values().stream().mapToLong(e -> e).sum()) {
            return true;
        }
        return false;
    }

    private static String searchItem(String name, String itemName) {
        if (name.length() == 3) {
            itemName = "Cash";
        } else if (name.toLowerCase().endsWith("gem")) {
            itemName = "Gem";
        } else if (name.toLowerCase().equals("gold")) {
            itemName = "Gold";
        }
        return itemName;
    }
}
