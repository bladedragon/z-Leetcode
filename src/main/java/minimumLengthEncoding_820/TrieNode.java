package minimumLengthEncoding_820;

public class TrieNode {
    //在建树的时候就开始计数
    public int count;
    public  TrieNode[] children;
    public boolean isEndingChar;

    TrieNode(char data){
        this.count = 0;
        isEndingChar = false;
        children = new TrieNode[26];
    }
}
