import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NewsMapper {
    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);

    NewsDTO newsToNewsDTO(News news);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createDate",ignore = true)
    @Mapping(target = "lastUpdateDate",ignore = true)
    News newsDTOToNews (NewsDTO newsDTO);
}
