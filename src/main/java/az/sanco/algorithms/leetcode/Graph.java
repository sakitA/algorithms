package az.sanco.algorithms.leetcode;

import java.util.Arrays;

/**
 * Created by sanco on 25.07.21.
 * algorithms
 */
public class Graph {
//    Map<String, Boolean> visited = new HashMap<>();
//
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        if(!wordList.contains(endWord)) return 0;
//
//        // store all words generic states
//        Map<String,List<String>> generics = findAllGenerics(wordList);
//
//        Pair p = new Pair(beginWord, 1);
//        ArrayDeque<Pair> queue = new ArrayDeque<>();
//        queue.push(p);
//        Map<String, Boolean> visited = new HashMap<>();
//
//        while(!queue.isEmpty()){
//            Pair current = queue.poll();
//            String currentWord = current.word;
//            for(int i=0;i<currentWord.length();i++){
//                String newWord = currentWord.substring(0,i)+"*"+currentWord.substring(i+1);
//                for(String adjacentWord: generics.getOrDefault(newWord, new ArrayList<>())){
//                    if(adjacentWord.equals(endWord)) return current.level+1;
//                    if(!visited.containsKey(adjacentWord)){
//                        visited.put(adjacentWord, true);
//                        queue.add(new Pair(adjacentWord, current.level+1));
//                    }
//                }
//            }
//        }
//        return 0;
//    }
//
//    private Map<String, List<String>> findAllGenerics(List<String> words){
//        Map<String, List<String>> generics = new HashMap<>();
//
//        for(String word: words){
//            for(int i=0;i<word.length();i++){
//                generics.computeIfAbsent(word.substring(0,i)+"*"+word.substring(i+1), e->new ArrayList<>()).add(word);
//            }
//        }
//
//        return generics;
//    }
//
//    class Pair{
//        String word;
//        int level;
//
//        public Pair(String word, int level) {
//            this.word = word;
//            this.level = level;
//        }
//    }
    public static void main(String[] args) {
        Graph g = new Graph();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.neighbors.addAll(Arrays.asList(n2,n4));
        n2.neighbors.addAll(Arrays.asList(n1,n3));
        n3.neighbors.addAll(Arrays.asList(n2,n4));
        n4.neighbors.addAll(Arrays.asList(n1,n3));

        System.out.println(g.cloneGraph(n1));
    }

    private Node[] visited;
    public Node cloneGraph(Node node) {
        visited = new Node[101];
        return cloneGraph(node);
    }
}
