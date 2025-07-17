package co.inventory.system.ld.application.usecase.users;

import co.inventory.system.ld.application.usecase.UseCaseWithOutRetuen;
import co.inventory.system.ld.application.usecase.UseCaseWithReturn;
import co.inventory.system.ld.domain.users.UserDomain;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.users.AuthResponse;

public interface RegisterNewUser extends UseCaseWithReturn<UserDomain, AuthResponse> {
}
