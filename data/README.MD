This folder stores local data files copied out of the cluster workflow.

The main files here are:

- the raw downloaded dataset file
- `train.json`
- `test.json`

`train.json` and `test.json` are produced during `Stage 3`. The modeling code first saves the splits to HDFS, and then the pipeline collects them back into this folder.

This folder contains the local copy of the data that was given to the ML models.
