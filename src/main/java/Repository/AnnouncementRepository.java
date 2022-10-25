package Repository;

import Model.Announcement.Announcement;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepository extends PagingAndSortingRepository<Announcement, Long> {
}
