This folder stores local copies of trained Spark ML models.

The models are trained on the cluster during `Stage 3`, saved to HDFS as `project/models/model1` and `project/models/model2`, and then copied back here.

These folders show that training finished and that a serializable Spark model was produced.

In this project:

- `model1` is the best Logistic Regression model after cross-validation
- `model2` is the best Random Forest model after cross-validation
