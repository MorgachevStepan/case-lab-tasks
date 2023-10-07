package hm3.Java8;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Stepan Morgachev
 * @date 01.10.2023 10:37
 */
public class Solution {
    public static void main(String[] args) {
        Developer dev1 = new Developer("Наташа", Arrays.asList("Java", "C++"));
        Developer dev2 = new Developer("Эрнест", Arrays.asList("Java", "Python"));
        Developer dev3 = new Developer("Элла", Arrays.asList("С#", "Python", "JavaScript"));
        Stream<Developer> developerStream = Stream.of(dev1, dev2, dev3);

        List<Developer> developersWithUniqueLanguages = developerStream
                .flatMap(dev -> dev.getLanguages().stream().map(lang -> new AbstractMap.SimpleEntry<>(dev, lang)))
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())
                ))
                .values()
                .stream()
                .filter(developerList -> developerList.size() == 1)
                .distinct()
                .flatMap(List::stream).toList();

        for(Developer s: developersWithUniqueLanguages)
            System.out.println(s);
    }
}
