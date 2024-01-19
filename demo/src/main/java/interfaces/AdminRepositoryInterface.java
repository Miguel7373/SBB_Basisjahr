package interfaces;

import Dtos.SubjectDto;

import java.util.List;

public interface AdminRepositoryInterface {
    void createNewSubject(SubjectDto newSubject);
    void editSubject(int i);
    List<SubjectDto> findAll();
    void deleteSubject(int i);
}
