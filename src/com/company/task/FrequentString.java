package com.company.task;

import java.util.*;

/**
 * Created by yasina on 20.02.16.
 */
public class FrequentString {

        private Iterator<String> iterator;
        private int size = 0;
        private List<String> resultList;

        /*

        Algorithm
        1) create map<Value Name, Amount>
        2) sort map, which was created in first step
        3) get frequent elements

        I'm using Map because:
         1)adding an item is done in O(1)
           because all the elements are inserted at the beginning of the chain;
         2)The operations get  and remove  can be performed in O(1),
          if the hash function distributes the elements and there are no collisions.
          The mean operating time is Θ (1 + α), where α - the load factor.
          In the worst case execution time can amount Θ(n) (all elements in one chain);
         */

        public FrequentString(Iterator<String> iterator){
            this.iterator = iterator;
        }

        public List<String> getMostFrequentElements(int count) {

            Map<String, Integer> unsortedMap = createMap();
            TreeMap<Integer, List<String>> sortedMap = sortMap(unsortedMap);

            resultList = new ArrayList<String>(count);

            //creating resultList only for values
            while(resultList.size() < count){
                try {
                    resultList.addAll(sortedMap.pollLastEntry().getValue());
                }catch (java.lang.NullPointerException e){
                    // if count > sortedMap.size()
                    return resultList.subList(0,resultList.size());
                }
            }

            return resultList.subList(0, count);
        }

        // create the map, where will be written count and name of each word
        private Map<String, Integer> createMap(){

            Map<String, Integer> words_map = new HashMap<String, Integer>();

            while(iterator.hasNext()){
                String current_word = iterator.next();
                // if iterator see that current_words already exists in map
                if (words_map.containsKey(current_word)){
                    // it's just upgrade existed item's value
                    words_map.put(current_word, words_map.get(current_word) + 1);
                } else {
                    // or put new item
                    words_map.put(current_word, 1);
                }
            }

            return words_map;
        }


        private TreeMap<Integer, List<String>> sortMap(Map<String, Integer> unsortedMap){

            // For sortedMap we need TreeMap<Integer, List<String>>.
            // I change positions of key and value because:
            // 1) Comparators works only with Key element
            // 2) If we have different String values with same keys,
            // we also need to save all of them, that's why i use List of Strings
            TreeMap<Integer, List<String>> sortedMap = new TreeMap<Integer, List<String>>(new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    return Integer.compare(a, b);
                }
            });

            // take each entrySet
            for (final Map.Entry<String, Integer> entry: unsortedMap.entrySet()){
                // if it's not first String Value with the same key
                if (sortedMap.containsKey(entry.getValue())){
                    sortedMap.get(entry.getValue()).add(entry.getKey());
                } else {
                    // or add new map item with one element in ArrayList<String>
                    sortedMap.put(entry.getValue(), new ArrayList<String>(1){{ add(entry.getKey());}});
                }
            }

            return sortedMap;
        }


}
