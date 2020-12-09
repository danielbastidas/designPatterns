import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

class Scratch {
    public static void main(String[] args) {
        String s1 = "ABCDEF";
        String s2 = "FBDAMN";
        System.out.println(commonChild(s1,s2));
    }

    static int commonChild(String s1, String s2) {
        int max = 0, index = 0, foundIndex = 0;
        Map<Character, Letter> s1Map = new LinkedHashMap<>();
        Map<Character, Letter> s2Map = new LinkedHashMap<>();
        StringBuilder commonChildStr = new StringBuilder();
        List<Letter> commonChildLetters = new ArrayList<>();

        for (int i =0;i< s1.length();i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            Letter l1 = new Letter(c1, 1, i);

            if (s1Map.containsKey(c1)) {
                l1 = s1Map.get(c1);
                l1.frequency++;
                l1.positions.add(i);

            } else {
                s1Map.put(c1, l1);
            }

            Letter l2 = new Letter(c2, 1, i);
            if (s2Map.containsKey(c2)) {
                l2 = s2Map.get(c2);
                l2.frequency++;
                l2.positions.add(i);

            } else {
                s2Map.put(c2, l2);
            }

        }

        evaluateStrings(s1Map, s2Map, commonChildLetters);

        max = Math.max(max, commonChildLetters.size());
        commonChildLetters.clear();

        evaluateStrings(s2Map, s1Map, commonChildLetters);

        max = Math.max(max, commonChildLetters.size());

        return max;

    }

    private static void evaluateStrings(Map<Character, Letter> s1Map,
                                        Map<Character, Letter> s2Map,
                                        List<Letter> commonChildLetters) {
        int min;
        for (Letter l: s1Map.values()) {
            if (s2Map.containsKey(l.character)) {
                min = Math.min(l.frequency, s2Map.get(l.character).frequency);

                List<Integer> clonedPos1 = new ArrayList<>(l.positions);
                List<Integer> clonedPos2 = new ArrayList<>(s2Map.get(l.character).positions);

                for (int i=0;i<min;i++) {
                    Letter lowestPosLetter = null;
                    if (clonedPos1.size() == 0) {
                        lowestPosLetter = (Letter) s2Map.get(l.character).clone();
                        lowestPosLetter.lowestIndex = clonedPos2.get(0);
                        clonedPos2.remove(0);
                        lowestPosLetter.positions=clonedPos2;

                    } else if (clonedPos2.size() == 0) {
                        lowestPosLetter = (Letter) l.clone();
                        lowestPosLetter.lowestIndex = clonedPos1.get(0);
                        clonedPos1.remove(0);
                        lowestPosLetter.positions = clonedPos1;

                    } else {
                        if (clonedPos1.get(0) < clonedPos2.get(0)) {
                            lowestPosLetter = (Letter) l.clone();
                            lowestPosLetter.lowestIndex = clonedPos1.get(0);
                            clonedPos1.remove(0);
                            lowestPosLetter.positions = clonedPos1;
                        } else {
                            lowestPosLetter =
                                    (Letter) s2Map.get(l.character).clone();
                            lowestPosLetter.lowestIndex = clonedPos2.get(0);
                            clonedPos2.remove(0);
                            lowestPosLetter.positions = clonedPos2;
                        }
                    }

                    if (commonChildLetters.size()>0) {
                        Letter lastLetterOnTheList =
                                commonChildLetters.get(commonChildLetters.size()-1);
                        if (lowestPosLetter.lowestIndex>lastLetterOnTheList.lowestIndex) {
                            commonChildLetters.add(lowestPosLetter);
                        }
                    } else {
                        commonChildLetters.add(lowestPosLetter);
                    }
                }
            }
        }
    }

    static class Letter implements Comparable<Letter> {
        Character character;
        int frequency;
        List<Integer> positions;
        int lowestIndex;

        public Letter(Character character, int frequency,
                      int position) {
            this.character = character;
            this.positions = new ArrayList<>();
            this.positions.add(position);
            this.frequency = frequency;
            this.lowestIndex = position;
        }

        @Override
        public int compareTo(Scratch.Letter o) {
            return Character.compare(this.character, o.character);
        }

        @Override
        protected Object clone() {

            Letter cloned = new Letter(this.character, this.frequency,
                    this.lowestIndex);
            cloned.positions = new ArrayList<>(this.positions);
            return cloned;
        }
    }
}