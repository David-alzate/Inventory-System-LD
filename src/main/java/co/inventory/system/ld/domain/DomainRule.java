package co.inventory.system.ld.domain;

public interface DomainRule<T> {

    void validate(T data);

}
