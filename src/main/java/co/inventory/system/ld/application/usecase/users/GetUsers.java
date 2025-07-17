package co.inventory.system.ld.application.usecase.users;

import java.util.List;

import co.inventory.system.ld.application.usecase.UseCaseWithReturn;
import co.inventory.system.ld.domain.users.UserDomain;

public interface GetUsers extends UseCaseWithReturn<UserDomain, List<UserDomain>>{

}
