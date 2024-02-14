import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        System.out.println("프로그램 시작");
        Scanner sc = new Scanner(System.in);
        ArrayList<Article> post = new ArrayList<>();
        int cnt = 1;
        while(true) {
            String test = sc.nextLine();
            if (test.equals("article list")){
                if (post.isEmpty()){
                    System.out.println("게시글이 없습니다.");
                }
                else {
                    for(int i =0; i<post.size(); i++){
                        System.out.println(i+1+"번째글 id : " + post.get(i).id);
                        System.out.println(i+1+"번째글 제목 : " + post.get(i).title);
                        System.out.println(i+1+"번째글 내용 : " + post.get(i).content);
                        System.out.println(i+1+"번째글 시간 : " + post.get(i).date);
                    }
                }
            }
            else if (test.equals("article write")){
                LocalDateTime now = LocalDateTime.now();
                String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
                System.out.print("제목 : ");
                String tempTitle = sc.nextLine();
                System.out.print("내용 : ");
                String tempContent = sc.nextLine();
                post.add(new Article(cnt, tempTitle,formatedNow, tempContent));
                System.out.println(cnt+"번 글이 생성되었습니다.");
                cnt++;
            }
            else if (test.equals("system exit")) {
                break;
            }
            else if (test.startsWith("article detail ") ) {
                int num;
                try {
                    num = Integer.parseInt(test.split(" ")[2]);
                }
                catch(Exception e) {
                    System.out.println("숫자를 입력하시오");
                    continue;
                }
                try {
                    Article temp = post.get(num - 1);
                    System.out.println(num+"번째글 id : " + temp.id);
                    System.out.println(num + "번째글 제목 : " + temp.title);
                    System.out.println(num + "번째글 내용 : " + temp.content);
                    System.out.println(num+"번째글 시간 : " + temp.date);
                }
                catch(Exception e) {
                    System.out.println("없는 게시글입니다.");
                }

            }

            else {
                System.out.println("존재하지 않는 명령어입니다.");
            }
        }
        sc.close();
        System.out.println("프로그램 끝");
    }
}

class Article {
    public int id;
    public String title;
    public String content;
    public String date;

    public Article(int id, String title, String date, String content) {
        this.id =id;
        this.title =title;
        this.date = date;
        this.content = content;
    }
}