package co.inventory.system.ld.application.usecase.users;

import java.util.List;

import co.inventory.system.ld.application.usecase.UseCaseWithReturn;
import co.inventory.system.ld.domain.users.UserTypeDomain;

public interface GetUserType extends UseCaseWithReturn<UserTypeDomain, List<UserTypeDomain>>{

}
