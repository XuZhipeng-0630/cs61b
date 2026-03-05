public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            deque.addLast(c);
        }
        return deque;
    }
    public boolean isPalindrome(String word) {
        if (word == null) {
            return false;
        }
        Deque<Character> deque = wordToDeque(word);
        return isPalindromeHelper(deque);
    }
    private boolean isPalindromeHelper(Deque<Character> deque) {
        if (deque.isEmpty() || deque.size() == 1) {
            return true;
        } else {
            return deque.removeFirst().equals(deque.removeLast()) && isPalindromeHelper(deque);
        }
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null) {
            return false;
        }
        Deque<Character> deque = wordToDeque(word);
        return isPalindromeHelper(deque, cc);
    }
    private boolean isPalindromeHelper(Deque<Character> deque, CharacterComparator cc) {
        if (deque.isEmpty() || deque.size() == 1) {
            return true;
        }  else {
            boolean b = cc.equalChars(deque.removeFirst(), deque.removeLast());
            return b && isPalindromeHelper(deque, cc);
        }
    }
}
