# KoBeTree: Kotlin Behavior Tree Library

## Description
KoBeTree is a powerful and flexible Kotlin library designed specifically for building behavior trees. Behavior trees are widely used in AI and game development to create complex, decision-driven behaviors for characters, NPCs, and more.

## Key Features
- **DSL API**: KoBeTree offers an intuitive and expressive Domain-Specific Language (DSL) for constructing behavior trees with ease.
- **Composite Nodes**: Implement complex decision-making logic using composite nodes like `Selector` and `Sequence`.
- **Decorator Nodes**: Fine-tune behaviors with decorator nodes like `Inverter` and `Repeater`.
- **Task Nodes**: Create custom task nodes using Kotlin lambdas for dynamic and specialized behaviors.
- **Blackboard**: Share data and information across nodes using a centralized blackboard.

## Installation
You can easily integrate KoBeTree into your Kotlin projects by adding the following dependency:

Add the repository to your project's `settings.gradle.kts` or `settings.gradle` file:

```gradle
dependencyResolutionManagement {
    ...
    repositories {
        ...
        maven {
            url = uri("https://maven.pkg.github.com/pererikbergman/github-packages")
        }
    }
}
```
### Gradle
```gradle
dependencies {
    implementation("com.rakangsoftware.kobetree:kobetree:0.1.0") // Replace with the latest version
}
```

### Maven
```xml
<dependencies>
    <dependency>
        <groupId>com.rakangsoftware.kobetree</groupId>
        <artifactId>kobetree</artifactId>
        <version>0.1.0</version> <!-- Replace with the latest version -->
    </dependency>
</dependencies>
```

## Getting Started
Here's a simple example of how to create a behavior tree using KoBeTree:

```kotlin
import com.rakangsoftware.kobetree.dsl.*

fun main() {
    // Create a blackboard to share data between nodes
    val blackboard = Blackboard().apply {
        put("health", 100)
        put("enemyInSight", true)
    }

    // Define and execute a behavior tree using the DSL
    val result = Selector(blackboard) {
        sequence {
            condition { blackboard.get<Int>("health") > 50 } // Check health condition
            condition { blackboard.get<Boolean>("enemyInSight") } // Check enemy condition
            task { println("Attack the enemy!") } // Execute attack task
        }

        sequence {
            condition { blackboard.get<Boolean>("enemyInSight") } // Check enemy condition
            task { println("Run away!") } // Execute escape task
        }
    }.execute()

    println("Behavior tree execution result: $result")
}
```

## Documentation
TBA

## License
KoBeTree is released under the [MIT License](LICENSE) for maximum flexibility and compatibility with your projects.

## Contribute
We welcome contributions from the community! If you have ideas for improvements, bug reports, or new features, please [open an issue](https://github.com/pererikbergman/kobetree-lib/issues) or [submit a pull request](https://github.com/pererikbergman/kobetree-lib/pulls).

## Acknowledgments
KoBeTree is inspired by the work of many AI and game development enthusiasts who have contributed to the field of behavior trees.

Paste your content here to scan...
SCAN