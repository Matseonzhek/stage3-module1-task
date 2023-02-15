import java.util.List;
import java.util.Scanner;

public class View implements Viewing {
    public View() {
    }

    @Override
    public NewsDTO getNewsDTO(Scanner scanner) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter content: ");
        String content = scanner.nextLine();
        System.out.print("Enter author ID: ");
        String authorID = scanner.nextLine();
        return new NewsDTO(title, content, Long.parseLong(authorID));
    }

    @Override
    public void printListOfNewsDTO(List<NewsDTO> newsDTOList) {
        newsDTOList.forEach(System.out::println);
    }

    @Override
    public void printNewsDTO(NewsDTO newsById) {
        System.out.println(newsById);
    }

    @Override
    public long getId(Scanner scanner) {
        System.out.print("Enter news ID: ");
        return Long.parseLong(scanner.nextLine());
    }

}
