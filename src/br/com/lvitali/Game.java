package br.com.lvitali;

import javax.swing.*;

public class Game {

    BinarySearchTree knowledgeTree;
    boolean infiniteLoop = true;

    public Game() {
        knowledgeTree = new BinarySearchTree();
    }

    private void setupGame() {
        knowledgeTree.insert(null, "Massa", true);
        knowledgeTree.insert(knowledgeTree.root, "Macarrão", true);
        knowledgeTree.insert(knowledgeTree.root, "Bolo de chocolate", false);
    }

    public void startGame() {
        if (knowledgeTree.isEmpty()) {
            setupGame();
        }

        int initialDialog = showInitialDialog();

        if (initialDialog == JOptionPane.CLOSED_OPTION) {
            infiniteLoop = false;
        }

        while (infiniteLoop) {
            guess(knowledgeTree.root);
        }
    }

    public void guess(Node node) {
        String question = "O prato que você pensou é " + node.getValue() + "?";
        int answer = JOptionPane.showConfirmDialog(null, question, "Confirm", JOptionPane.YES_NO_OPTION);

        if (answer == JOptionPane.OK_OPTION) {
            if (node.isLeaf()) {
                win();
            } else {
                guess(node.getRightChild());
            }
        } else {
            if (node.getRightChild() == null) {
                askInformationAboutWrongGuess(node);
                startGame();
            } else {
                guess(node.getLeftChild());
            }
        }
    }

    private int showInitialDialog() {
        Object[] options = {"Ok"};
        return JOptionPane.showOptionDialog(null, "Pense em um prato que gosta" , "Jogo Gourmet", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    }

    private void win() {
        JOptionPane.showMessageDialog(null, "Acertei de novo!");
        startGame();
    }

    private void askInformationAboutWrongGuess(Node node) {
        String playerThoughtIn = JOptionPane.showInputDialog("Qual prato você pensou?");
        String hint = JOptionPane.showInputDialog(playerThoughtIn + " é _________ mas " + node.getValue() + " não.");

        changeNodeToHintValue(node, hint, playerThoughtIn);
    }

    private void changeNodeToHintValue(Node node, String hint, String value) {
        String wrongGuess = node.getValue();
        node.setValue(hint);
        node.setLeftChild(new Node(wrongGuess));
        node.setRightChild(new Node(value));
    }
}
