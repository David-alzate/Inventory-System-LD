package co.inventory.system.ld.application.usecase;

public interface UseCaseWithReturn<D, R> {
	R execute(D domain);
}	