package gateways.user;

import com.nrslib.domain.model.user.User;
import com.nrslib.domain.model.user.UserId;
import com.nrslib.domain.model.user.UserName;
import com.nrslib.domain.model.user.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EBeanUserRepository implements UserRepository {
    @Override
    public void save(User user) {
        UserId id = user.getId();
        models.User userData = Optional
                .ofNullable(models.User.find.byId(id.getValue()))
                .orElseGet(() ->createNew(id));

        userData.setName(user.getName().getValue());

        models.User.db().save(userData);
    }

    @Override
    public void remove(User user) {
        models.User.find.byId(user.getId().getValue()).delete();
    }

    @Override
    public List<User> findAll() {
        List<models.User> all = models.User.find.all();

        List<User> results = all.stream()
                .map(this::convert)
                .collect(Collectors.toList());

        return results;
    }

    @Override
    public Optional<User> find(UserId id) {
        String userId = id.getValue();

        models.User user = models.User.find.byId(userId);

        if(user != null) {
            User userModel = convert(user);
            return Optional.of(userModel);
        }else{
            return Optional.empty();
        }
    }

    private models.User createNew(UserId id) {
        models.User instance = new models.User();
        instance.setId(id.getValue());
        return instance;
    }

    private User convert(models.User user){
        return new User(
                new UserId(user.getId()),
                new UserName(user.getName())
        );
    }
}
