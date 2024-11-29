package co.inventory.system.ld.application.primaryports.interactor;

public interface InteractorWithOutReturn<T> {

	void execute(T data);

}