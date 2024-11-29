package co.inventory.system.ld.application.primaryports.interactor;

public interface InteractorWithReturn<T, R> {

	R execute(T data);

}