import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node {
    char character;
    int frequency;
    Node left, right;

    Node(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.left = this.right = null;
    }

    Node(int frequency) {
        this.frequency = frequency;
        this.left = this.right = null;
    }
}

class FrequencyComparator implements Comparator<Node> {
    public int compare(Node node1, Node node2) {
        return node1.frequency - node2.frequency;
    }
}

public class HuffmanCoding {
    public static void generateCodes(Node root, String code, Map<Character, String> huffmanCodes) {
        if (root == null) {
            return;
        }
        if (root.character != '\0') {
            huffmanCodes.put(root.character, code);
        }
        generateCodes(root.left, code + "0", huffmanCodes);
        generateCodes(root.right, code + "1", huffmanCodes);
    }

    public static Node buildHuffmanTree(Map<Character, Integer> frequencyMap) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new FrequencyComparator());
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            priorityQueue.add(new Node(entry.getKey(), entry.getValue()));
        }
        while (priorityQueue.size() > 1) {
            Node left = priorityQueue.poll();
            Node right = priorityQueue.poll();
            Node internalNode = new Node(left.frequency + right.frequency);
            internalNode.left = left;
            internalNode.right = right;
            priorityQueue.add(internalNode);
        }
        return priorityQueue.poll();
    }

    public static String encodeText(String text, Map<Character, String> huffmanCodes) {
        StringBuilder encodedText = new StringBuilder();
        for (char character : text.toCharArray()) {
            encodedText.append(huffmanCodes.get(character));
        }
        return encodedText.toString();
    }

    public static String decodeText(String encodedText, Node root) {
        StringBuilder decodedText = new StringBuilder();
        Node current = root;
        for (char bit : encodedText.toCharArray()) {
            if (bit == '0') {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current.left == null && current.right == null) {
                decodedText.append(current.character);
                current = root;
            }
        }
        return decodedText.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the text to be encoded:");
        String text = scanner.nextLine();
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char character : text.toCharArray()) {
            frequencyMap.put(character, frequencyMap.getOrDefault(character, 0) + 1);
        }
        Node root = buildHuffmanTree(frequencyMap);
        Map<Character, String> huffmanCodes = new HashMap<>();
        generateCodes(root, "", huffmanCodes);
        System.out.println("Huffman Codes: " + huffmanCodes);
        String encodedText = encodeText(text, huffmanCodes);
        System.out.println("Encoded Text: " + encodedText);
        String decodedText = decodeText(encodedText, root);
        System.out.println("Decoded Text: " + decodedText);
        scanner.close();
    }
}
