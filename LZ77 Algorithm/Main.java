import java.util.ArrayList;
    
/**
 *
 * @author Mahmoud Abd El-Ghany
 * version 1.0
 */
public class Main {

    static String word = "aababc";
    static ArrayList<Tag> tag = new ArrayList<Tag>();
    static Tag tags;
    static Tag dtag;
    static boolean flag = true;

    public static void de(ArrayList<Tag> de_tag) {

        String po = "";
        for (int i = 0; i < de_tag.size(); i++) {
            dtag = de_tag.get(i);
            int j = po.length() - dtag.getPosition();
            int index = 0;
            if (dtag.getPosition() != 0) {
                while (index < dtag.getLength() && j < po.length()) {
                   // System.out.println(po);
                    // System.out.println(po.charAt(j));
                    po += po.charAt(j++);
                    index++;
                }
            }
            po += dtag.getNext();
        }
        System.out.println(po);
    }

    public static int findLastIdx(String A, String B) {
        int ret = -1, counter = 0, ch = 0;
        for (int i = 0; i < A.length(); i++) {
            int p = i, k = 0;
            while (p < A.length() && k < B.length() && A.charAt(p) == B.charAt(k)) {
                p++;
                k++;
                counter++;
            }
            if (p != i && counter >= ch) {
                ret = i;
                flag = false;
                ch = counter;
            }
            if (k == B.length()&&counter >= ch) {
                ret = i;
                flag = true;
                ch = counter;
            }
            counter = 0;
        }
        return ret;
    }
  
    public static void main(String args[]) {
        //System.out.println(findLastIdx("ab", "ad"));
        String buffer = "";
        for (int i = 0; i < word.length(); i++) {
            if (i == word.length() - 1) {
                tags = new Tag(0, 0, word.charAt(i));
                tag.add(tags);
                break;
            }
            for (int j = 0; j < i; j++) {
                buffer += word.charAt(j); // A in out function
            }
            String currSub = ""; // B in our funtion
            currSub += word.charAt(i);
            int l = i + 1;
            //System.out.println("loop" + i);
            while (l < word.length() && findLastIdx(buffer, currSub) != -1) {
                if (flag == true) {
                    currSub += word.charAt(l++);
                } else {
                    break;
                }
            }
            if (findLastIdx(buffer, currSub) == -1) {
                tags = new Tag(0, 0, word.charAt(i));
            } else {
                int pos = i - findLastIdx(buffer, currSub);
                int length = currSub.length() - 1;
                i = i + length;
                tags = new Tag(pos, length, word.charAt(i));
            }
            buffer = "";
            tag.add(tags);

        }
        System.out.println(tag);
        de(tag);

    }
}
