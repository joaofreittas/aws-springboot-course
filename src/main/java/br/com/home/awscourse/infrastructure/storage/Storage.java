package br.com.home.awscourse.infrastructure.storage;

import br.com.home.awscourse.domain.Note;

public interface Storage {

    void save(Note note);

}
