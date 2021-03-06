package com.github.WordLadder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;

class Node<T> {
    T data;
    Node<T> parent;

    public Node(T data, Node<T> parent) {
        this.data = data;
        this.parent = parent;
    }
}

class NewLevelResult {
    boolean isFound;
    List<Node<String>> leaves;

    public NewLevelResult(boolean isFound, List<Node<String>> node) {
        this.isFound = isFound;
        this.leaves = node;
    }
}

public class Solution {
    boolean isFound = false;

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        wordList.remove(endWord);

        if (isOneLetterDiff(beginWord, endWord)) {
            return singletonList(Arrays.asList(beginWord, endWord));
        } else {
            Node<String> root = new Node<>(endWord, null);
            List<Node<String>> leaves = singletonList(root);

            while (!isFound) {
                leaves = goOneLevelDeeperForEach(leaves, beginWord, wordList);
                if (leaves.size() == 0) {
                    break;
                }
            }

            return leaves.stream()
                    .map(Solution::allWords)
                    .collect(Collectors.toList());
        }
    }

    private List<Node<String>> goOneLevelDeeperForEach(List<Node<String>> nodes, String endWord, Set<String> wordList) {
        for (Node<String> node : nodes) {
            wordList.remove(node.data);//avoid re-counting siblings
        }

        List<NewLevelResult> results = nodes.parallelStream()
                .map(node -> goOneLevelDeeper(node, endWord, wordList))
                .collect(Collectors.toList());

        if (results.stream().anyMatch(res -> res.isFound)) {
            isFound = true;
            return results.stream()
                    .filter(res -> res.isFound)
                    .flatMap(res -> res.leaves.stream())
                    .collect(Collectors.toList());
        } else {
            return results.stream()
                    .flatMap(res -> res.leaves.stream())
                    .collect(Collectors.toList());
        }
    }

    private static NewLevelResult goOneLevelDeeper(Node<String> node, String endWord, Set<String> wordList) {
        if (isOneLetterDiff(node.data, endWord)) {
            Node<String> end = new Node<>(endWord, node);
            return new NewLevelResult(true, singletonList(end));
        } else {
            List<Node<String>> nextSteps = oneLetterDiffsOf(node.data).stream()
                    .filter(wordList::contains)
                    .map(w -> new Node<>(w, node))
                    .collect(Collectors.toList());
            return new NewLevelResult(false, nextSteps);
        }
    }

    private static List<String> allWords(Node<String> step) {
        List<String> strs = new ArrayList<>();
        while (step.parent != null) {
            strs.add(step.data);
            step = step.parent;
        }
        strs.add(step.data);//add root
        return strs;
    }

    public static boolean isOneLetterDiff(String a, String b) {
        int diffs = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diffs++;
                if (diffs == 2) {
                    return false;
                }
            }
        }
        return diffs == 1;
    }

    private static List<String> oneLetterDiffsOf(String word) {
        List<String> diffs = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != word.charAt(i)) {
                    StringBuilder sb = new StringBuilder(word);
                    sb.setCharAt(i, c);
                    diffs.add(sb.toString());
                }
            }
        }
        return diffs;
    }
}
