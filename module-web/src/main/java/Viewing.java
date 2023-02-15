import java.util.List;
import java.util.Scanner;

public interface Viewing{
    NewsDTO getNewsDTO(Scanner scanner);
    long getId(Scanner scanner);
    void printListOfNewsDTO(List<NewsDTO> newsDTOList);
    void printNewsDTO(NewsDTO newsById);
}
