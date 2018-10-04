package SaveLoad;

import Model.Storage;
import Model.individualStorage;

import java.io.IOException;
import java.util.List;

public interface Load {
    public List<String> load() throws IOException;
}
