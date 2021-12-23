package async;

import java.io.IOException;
import java.nio.ByteBuffer;

public interface ByteBufferFeeder extends NonBlockingInputFeeder{
    public void feedInput(ByteBuffer buffer) throws IOException;
}
