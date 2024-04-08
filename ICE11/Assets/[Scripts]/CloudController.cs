using System.Collections;
using System.Collections.Generic;
using Unity.VisualScripting;
using UnityEngine;

public class CloudController : MonoBehaviour
{
    public float topBound;
    public float bottomBound;
    public float leftBound;
    public float rightBound;

    // Random speed range for vertical movement
    public float minVerticalSpeed;
    public float maxVerticalSpeed;

    // Random drift range for horizontal movement
    public float minHorizontalDrift;
    public float maxHorizontalDrift;

    private float verticalSpeed;
    private float horizontalDrift;

    // Start is called before the first frame update
    void Start()
    {
        ResetGameObject();
    }

    // Update is called once per frame
    void Update()
    {
        Move();
        CheckBounds();
    }

    void Move()
    {
        // Move the cloud vertically
        transform.position -= new Vector3(0, verticalSpeed, 0);

        // Drift the cloud horizontally
        transform.position += new Vector3(horizontalDrift, 0, 0);
    }

    void ResetGameObject()
    {
        // Set random position within specified bounds
        var randomX = Random.Range(leftBound, rightBound);
        transform.position = new Vector3(randomX, topBound, 0);

        // Set random vertical speed within specified range
        verticalSpeed = Random.Range(minVerticalSpeed, maxVerticalSpeed);

        // Set random horizontal drift within specified range
        horizontalDrift = Random.Range(minHorizontalDrift, maxHorizontalDrift);
    }

    void CheckBounds()
    {
        if (transform.position.y <= bottomBound )
        {
            ResetGameObject();
        }

        if (transform.position.x<= leftBound || transform.position.x >= rightBound) 
        {
            ResetGameObject() ;
        }

    }
}

