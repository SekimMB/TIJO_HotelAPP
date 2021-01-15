package com.simple.HotelApp.service;

import com.simple.HotelApp.domain.entity.Reservation;
import com.simple.HotelApp.domain.repository.ReservationRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class FakeReservationRepository implements ReservationRepository {
    Map<Integer, Reservation> values = new ConcurrentHashMap<>();
    @Override
    public List<Reservation> findAll() {
        return new ArrayList<>(values.values());
    }

    @Override
    public List<Reservation> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Reservation> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Reservation> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {
    values.remove(integer);
    }

    @Override
    public void delete(Reservation reservation) {

    }

    @Override
    public void deleteAll(Iterable<? extends Reservation> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Reservation> S save(S s) {
        if(s.getId_reservation() == null) {
            s.setId_reservation(new Random().nextInt());
        }
        values.put(s.getId_reservation(), s);

        return s;
    }

    @Override
    public <S extends Reservation> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Reservation> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Reservation> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Reservation> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Reservation getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends Reservation> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Reservation> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Reservation> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Reservation> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Reservation> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Reservation> boolean exists(Example<S> example) {
        return false;
    }
}
