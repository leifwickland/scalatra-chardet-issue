# scalatra-chardet-issue #

When serving `text/plain; charset=utf-8` content as an array of bytes which has
already been encoded in the target character set, Scalatra is extremely slow.
Profiling reveals that the slowdown occurs in `FileCharset.apply()`.

## Reproduction steps ##

```sh
$ cd scalatra-chardet-issue
$ ./sbt
> container:start
> time curl http://localhost:8080/1 >/dev/null
# Serves content snappily
> time curl http://localhost:8080/500000 >/dev/null
# Wait patiently 
```

