# smile-weka-package
Weka package wrapping SMILE algorithms (http://haifengl.github.io/).

## Algorithms

* Classification

  * [smile.classification.SmileRandomForest](https://haifengl.github.io/smile/api/java/smile/classification/RandomForest.html)
  * [smile.classification.SmileSVM](https://haifengl.github.io/smile/api/java/smile/classification/SVM.html)
  
* Regression
  
  * [smile.regression.SmileGaussianProcessRegression](https://haifengl.github.io/smile/api/java/smile/regression/GaussianProcessRegression.html)
  * [smile.regression.SmileRandomForest](https://haifengl.github.io/smile/api/java/smile/regression/RandomForest.html)
  * [smile.regression.SmileRidgeRegression](https://haifengl.github.io/smile/api/java/smile/regression/RidgeRegression.html)
  * [smile.regression.SmileSVR](https://haifengl.github.io/smile/api/java/smile/regression/SVR.html)

* Clustering

  * [smile.clustering.SmileBIRCH](https://haifengl.github.io/smile/api/java/smile/clustering/BIRCH.html)
  * [smile.clustering.SmileCLARANS](https://haifengl.github.io/smile/api/java/smile/clustering/CLARANS.html)
  * [smile.clustering.SmileKMeans](https://haifengl.github.io/smile/api/java/smile/clustering/KMeans.html)

* Kernels

  * [smile.math.kernel.SmileGaussianKernel](https://haifengl.github.io/smile/api/java/smile/math/kernel/GaussianKernel.html)
  * [smile.math.kernel.SmileHellingerKernel](https://haifengl.github.io/smile/api/java/smile/math/kernel/HellingerKernel.html)
  * [smile.math.kernel.SmileHyperbolicTangentKernel](https://haifengl.github.io/smile/api/java/smile/math/kernel/HyperbolicTangentKernel.html)
  * [smile.math.kernel.SmileLaplacianKernel](https://haifengl.github.io/smile/api/java/smile/math/kernel/LaplacianKernel.html)
  * [smile.math.kernel.SmileLinearKernel](https://haifengl.github.io/smile/api/java/smile/math/kernel/LinearKernel.html)
  * [smile.math.kernel.SmilePearsonKernel](https://haifengl.github.io/smile/api/java/smile/math/kernel/PearsonKernel.html)
  * [smile.math.kernel.SmilePolynomialKernel](https://haifengl.github.io/smile/api/java/smile/math/kernel/PolynomialKernel.html)
  * [smile.math.kernel.SmileThinPlateSplineKernel](https://haifengl.github.io/smile/api/java/smile/math/kernel/ThinPlateSplineKernel.html)

* Distance functions

  * [smile.math.distance.SmileEuclideanDistance](https://haifengl.github.io/smile/api/java/smile/math/distance/EuclideanDistance.html)


## Releases

* TODO


## How to use packages

For more information on how to install the package, see:

https://waikato.github.io/weka-wiki/packages/manager/


## Maven

Add the following dependency in your `pom.xml` to include the package:

```xml
    <dependency>
      <groupId>com.github.fracpete</groupId>
      <artifactId>smile-weka-package</artifactId>
      <version>TODO</version>
      <type>jar</type>
      <exclusions>
        <exclusion>
          <groupId>nz.ac.waikato.cms.weka</groupId>
          <artifactId>weka-dev</artifactId>
        </exclusion>
      </exclusions>
    </dependency>
```

