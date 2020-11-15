package pl.infoshare.junit5._2_in_memory_pattern;

import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;
import pl.infoshare.junit5.domain.Patient;
import pl.infoshare.junit5.domain.PatientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Primary
@NoRepositoryBean
public class InMemoryPatientRepository implements PatientRepository {

    private final List<Patient> patients = new ArrayList<>();

    @Override
    public List<Patient> findAll() {
        return patients;
    }

    @Override
    public List<Patient> findAll(Sort sort) {
        throw new IllegalStateException("not implemented");
    }

    @Override
    public Page<Patient> findAll(Pageable pageable) {
        throw new IllegalStateException("not implemented");
    }

    @Override
    public List<Patient> findAllById(Iterable<Integer> integers) {
        throw new IllegalStateException("not implemented");
    }

    @Override
    public long count() {
        return patients.size();
    }

    @Override
    public void deleteById(Integer integer) {
        throw new IllegalStateException("not implemented");

    }

    @Override
    public void delete(Patient patient) {
        throw new IllegalStateException("not implemented");

    }

    @Override
    public void deleteAll(Iterable<? extends Patient> iterable) {
        throw new IllegalStateException("not implemented");

    }

    @Override
    public void deleteAll() {
        throw new IllegalStateException("not implemented");

    }

    @Override
    public <S extends Patient> S save(S s) {
        patients.add(s);
        return s;
    }

    @Override
    public <S extends Patient> List<S> saveAll(Iterable<S> entities) {
        throw new IllegalStateException("not implemented");

    }

    @Override
    public Optional<Patient> findById(Integer id) {
        return patients.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Patient> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Patient> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Patient getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends Patient> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Patient> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Patient> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Patient> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Patient> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Patient> boolean exists(Example<S> example) {
        return false;
    }
}
