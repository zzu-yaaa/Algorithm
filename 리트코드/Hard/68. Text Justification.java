class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int len = 0;
        List<String> wordList = new ArrayList<>();
        List<String> result = new ArrayList<>();

        for(String word : words){
            // 단어의 조합이 maxWidth를 넘어가는 경우
            if(len + word.length() + wordList.size() > maxWidth){
                int space = (maxWidth - len) / Math.max(1, wordList.size()-1);
                int remain = (maxWidth - len) % Math.max(1, wordList.size()-1);

                StringBuilder temp = new StringBuilder();
                // 한 문장에 단어가 한개일때
                if(wordList.size() == 1){
                    temp.append(wordList.get(0));
                    temp.append(" ".repeat(space));
                }
                // 두 개 이상일 떄
                else{
                    for(int i=0; i<wordList.size()-1; i++){
                        temp.append(wordList.get(i));
                        int extraSpace = space;
                        if(remain > 0){
                            extraSpace += 1;
                            remain -= 1;
                        }
                        temp.append(" ".repeat(extraSpace));
                    }
                    temp.append(wordList.get(wordList.size()-1));
                }

                result.add(temp.toString());
                wordList.clear();
                len = 0;

            }
            wordList.add(word);
            len += word.length();
        }

        // 마지막줄 처리
        String last = String.join(" ", wordList);
        int space = maxWidth - last.length();
        result.add(last + " ".repeat(space));

        return result;


    }
}