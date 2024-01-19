package Repository;

import Dtos.SubjectDto;
import interfaces.AdminRepositoryInterface;

import java.util.List;

public class AdminRepository implements AdminRepositoryInterface {
    @Override
    public void createNewSubject(SubjectDto newSubject) {
    }
    @Override
    public void editSubject(int i) {
    }
    @Override
    public List<SubjectDto> findAll() {
        return null;
    }
    @Override
    public void deleteSubject(int i) {
    }
}
