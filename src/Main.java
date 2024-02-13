import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        System.out.println("프로그램 시작");
        Scanner sc = new Scanner(System.in);
        ArrayList<String> post = new ArrayList<>();
        ArrayList<String> content = new ArrayList<>();

        while(true) {
            String test = sc.nextLine();
            if (test.equals("article list")){
                if (post.isEmpty()){
                    System.out.println("게시글이 없습니다.");
                }
                else {
                    for(int i =0; i<post.size(); i++){
                        System.out.println(i+1+"번째글 제목 : " + post.get(i));
                        System.out.println(i+1+"번째글 내용 : " + content.get(i));
                    }
                }
            }
            else if (test.equals("article write")){
                System.out.print("제목 : ");
                String tempPost = sc.nextLine();
                post.add(tempPost);
                System.out.print("내용 : ");
                String tempContent = sc.nextLine();
                content.add(tempContent);
                System.out.println(post.size()+"번 글이 생성되었습니다.");
            }
            else if (test.equals("system exit")) {
                break;
            }
            else {
                System.out.println("존재하지 않는 명령어입니다.");
            }
        }
        sc.close();
        System.out.println("프로그램 끝");
    }
}