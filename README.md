# cache-stampede-repro

This reproducer exposes a simple API along with a scheduled bean calling the API a number of times concurrently.
The expectation would be only one console line printed as all but one singular thread are locked out and forced to wait
for the cached result. However, as can be seen in the example, multiple requests are able to make it into the cache method.

The issue seems to be present in the last 3 minor versions of 2.16 but is gone in 3.1.1